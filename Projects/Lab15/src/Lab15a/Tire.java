package Lab15a;

public class Tire {

	private String size;

	public Tire(String siz) {
		size = siz;
	}

	public String getSize() {
		return size;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tire other = (Tire) obj;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}


}
