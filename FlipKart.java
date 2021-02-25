package Ecommerce;
import java.util.ArrayList;

public class FlipKart {
public ProductsCatalog productsCatalog;

public FlipKart()
{
	productsCatalog =new ProductsCatalog();
}
public static void main(String[] args)
{
			Customer Aru=new Customer("Arushi Mittal","9834567897");
			Seller dailyNeedsGrocery=new Seller("Daliy Needs Grocery","9874567897");
			Seller fashionPoint=new Seller("Fashion Point","7554567897");
			Seller digiElectronics = new Seller("Digi Electronics","9876598765");
		    Category electronics = new Category("Electronics");
		    Category cosmetics = new Category("Cosmetics");
		    Category grocery = new Category("Groceries");
		    Category clothing = new Category("Clothing");
		    FlipKart myFlipkart=new FlipKart();
		    myFlipkart.productsCatalog.addCategory(clothing);
		    myFlipkart.productsCatalog.addCategory(grocery);
		    myFlipkart.productsCatalog.addCategory(cosmetics);
		    myFlipkart.productsCatalog.addCategory(electronics);
		    digiElectronics.registerProduct(myFlipkart.productsCatalog,
            new Product("Mobile","Latest Technology",10000.00,electronics,5));

            // Seller Digi Electronics adding Camera to myFlipKart catalog
            digiElectronics.registerProduct(myFlipkart.productsCatalog, //
            new Product("Camera","Advanced Technology",50000.00,electronics,10));

            // Seller FashionPoint adding Wearbles to myFlipKart catalog
            fashionPoint.registerProduct(myFlipkart.productsCatalog, //
            new Product("Mens Jackets","XL - Size",1000.00,clothing,10));
            
            fashionPoint.registerProduct(myFlipkart.productsCatalog, //
            new Product("Jackets","XL - Size",1000.00,clothing,10));
            
            // Seller FashionPoint adding Cosmetics to myFlipKart catalog
            fashionPoint.registerProduct(myFlipkart.productsCatalog, // 
            new Product("Nail Paint","Red Color",500.00,cosmetics,25));

            // Seller dailyNeedsGrocery adding grocery to myFlipKart catalog
            dailyNeedsGrocery.registerProduct(myFlipkart.productsCatalog, //
            new Product("Sugar","Fine quality",40.00,grocery,1000));

            // Seller dailyNeedsGrocery adding grocery to myFlipKart catalog
            dailyNeedsGrocery.registerProduct(myFlipkart.productsCatalog, //
            new Product("Milk","100% Pure",50.00,grocery,250));
            
            dailyNeedsGrocery.registerProduct(myFlipkart.productsCatalog, //
            new Product("Toned Milk","Hygenic and Pure",45.00,grocery,250));
            
            dailyNeedsGrocery.registerProduct(myFlipkart.productsCatalog, //
            new Product("Milk Cream","Natural",145.00,grocery,100));


            // Customer searching for product --> milk
            ArrayList<Product> milkResults = myFlipkart.productsCatalog.searchProduct("Milk");
            //System.out.println(milkResults);

            // Customer searching for all the products in grocery
            ArrayList<Product> groceryProducts = myFlipkart.productsCatalog.searchCategory("Groceries");
            //System.out.println(groceryProducts);

            // Customer adding 10 packets of milk to cart
            Item milkTenPackets = new Item(milkResults.get(0),10);
            Aru.addItemToCart(milkTenPackets);

            // Printing current cart status
            Aru.printCartItems();

            // Customer searching for another product --> camera
            ArrayList<Product> cameraResults = myFlipkart.productsCatalog.searchProduct("CaMeRa");
            //System.out.println(cameraResults);

            // Customer adding 1 camera to cart
            Item oneCamera = new Item(cameraResults.get(0),1);
            Aru.addItemToCart(oneCamera);

            // Printing current cart status
            Aru.printCartItems();

            // Customer updating quantity of milk packets from 10 to 15
            Aru.updateItemCount(milkTenPackets,15);

            // Printing current cart status
            Aru.printCartItems();

            // Customer placing the order
            Aru.placeOrder();

            // Customer cart is empty after checkout
            Aru.printCartItems();

            // Printing the current Order of customer
            System.out.println(Aru.getCurrentOrder());

            // Customer order is moved to shipment
            Shipment s = Aru.getCurrentOrder().moveToShipment();

            // Printing the shipment details
            System.out.println(s);

   
}
}
