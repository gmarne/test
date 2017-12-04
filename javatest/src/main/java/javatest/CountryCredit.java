package javatest;

/**
 * Class to be used as a key in the map.
 *
 */
public class CountryCredit {
	private String country;
	private String creditRating;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	CountryCredit() {
	}

	CountryCredit(String country, String creditRating) {
		this.country = country;
		this.creditRating = creditRating;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass().equals(this.getClass())) {
			CountryCredit that = (CountryCredit) obj;
			return this.country.equals(that.country)
					&& this.creditRating.equals(that.creditRating);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return country.hashCode() + creditRating.hashCode();
	}
	
	@Override
	public String toString() {
		return "Country : " + this.country + ", CreditRating : " + this.creditRating;
	}
}
