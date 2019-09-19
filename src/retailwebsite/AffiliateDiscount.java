package retailwebsite;

/**
 * 
 * @author Reyhan_FR879
 * Discount apply if user have affiliation with its retail
 */
public class AffiliateDiscount implements Discount {

	@Override
	public float getDiscount() {
		return .1f;
	}

}
