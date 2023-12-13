import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {

    public static void assign(Object to, Object from) {
        Class<?> toClass = to.getClass();
        Class<?> fromClass = from.getClass();

        Method[] fromMethods = fromClass.getMethods();
        for (Method fromMethod : fromMethods) {
            if (isGetter(fromMethod)) {
                String propertyName = getPropertyName(fromMethod);
                Method toMethod = findSetter(toClass, propertyName, fromMethod.getReturnType());
                if (toMethod != null) {
                    try {
                        Object value = fromMethod.invoke(from);
                        toMethod.invoke(to, value);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static boolean isGetter(Method method) {
        String name = method.getName();
        return (name.startsWith("get") || name.startsWith("is"))
                && method.getParameterCount() == 0
                && !void.class.equals(method.getReturnType());
    }

    private static String getPropertyName(Method method) {
        String name = method.getName();
        if (name.startsWith("get")) {
            return name.substring(3);
        } else if (name.startsWith("is")) {
            return name.substring(2);
        } else {
            return "";
        }
    }

    private static Method findSetter(Class<?> clazz, String propertyName, Class<?> returnType) {
        String setterName = "set" + propertyName;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(setterName)
                    && method.getParameterCount() == 1
                    && method.getReturnType().equals(void.class)
                    && method.getParameterTypes()[0].isAssignableFrom(returnType)) {
                return method;
            }
        }
        return null;
    }
}
