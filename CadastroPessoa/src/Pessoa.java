
public class Pessoa {
	private String nome;
	private double mediaA;
	private double mediaB;
	private double mediaFinal;
	
	
	public Pessoa() {
		
	}


	public String getNome() {
		return nome;
	}


	public double getMediaFinal() {
		return mediaFinal;
	}


	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getMediaA() {
		return mediaA;
	}


	public void setMediaA(double mediaA) {
		this.mediaA = mediaA;
	}


	public double getMediaB() {
		return mediaB;
	}


	public void setMediaB(double mediaB) {
		this.mediaB = mediaB;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(mediaA);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mediaB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mediaFinal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (Double.doubleToLongBits(mediaA) != Double.doubleToLongBits(other.mediaA))
			return false;
		if (Double.doubleToLongBits(mediaB) != Double.doubleToLongBits(other.mediaB))
			return false;
		if (Double.doubleToLongBits(mediaFinal) != Double.doubleToLongBits(other.mediaFinal))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", mediaA=" + mediaA + ", mediaB=" + mediaB + ", mediaFinal=" + mediaFinal
				+ "]";
	}
	
	
	
	
}