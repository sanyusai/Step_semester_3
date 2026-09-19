class CartData {

    private double[] prices;
    private int itemCount;
    private final String cartId;

    public CartData(String cartId, int maxItems) {

        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {

        if (itemCount >= prices.length) {
            System.out.println("Item rejected: Cart is full");
            return;
        }

        prices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total = total + prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }
}

public class ShoppingCart {

    public static void main(String[] args) {

        CartData cart = new CartData("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}

