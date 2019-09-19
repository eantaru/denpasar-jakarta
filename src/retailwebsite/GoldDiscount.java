package retailwebsite;

/**
 * 
 * @author Reyhan_FR879
 * Discount apply if user over than 2 years
 */
public class GoldDiscount implements Discount {

	@Override
	public float getDiscount() {
		return .05f;
	}

}
