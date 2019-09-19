package retailwebsite;

/**
 * 
 * @author Reyhan_FR879
 * Discount apply if user is employee of its Retail
 */
public class EmployeeDiscount implements Discount {

	@Override
	public float getDiscount() {
		return .3f;
	}

}
