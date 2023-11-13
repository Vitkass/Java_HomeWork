public enum TradeType {
    HatchBack{
        @Override
        void createTrade(Trade trade, int price) {
            trade = new HatchBackTrade(trade.price);
        }
    },

    Sedan{
        @Override
        void createTrade(Trade trade, int price) {
            trade = new SedanTrade(price);
        }
    },

    Suv{
        @Override
        void createTrade(Trade trade, int price) {
            trade = new SuvTrade(price);
        }
    },

    PickUp{
        @Override
        void createTrade(Trade trade, int price) {
            trade = new PickupTrade(price);
        }
    };

    abstract void createTrade(Trade trade, int price);

}
