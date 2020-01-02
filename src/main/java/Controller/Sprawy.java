package Controller;

public class Sprawy {
	Integer idSprawy;
	String DanPoszk,DanSprawcy,DatRozp,DatZak,StatSpraw,RodzSzkody,Uwagi;

	public Sprawy(Integer idSprawy, String DanPoszk , String DanSprawcy, String DatRozp,String DatZak,String StatSpraw,String RodzSzkody,String Uwagi) {
		this.idSprawy= idSprawy;
		this.DanPoszk=DanPoszk;
	    this.DanSprawcy=DanSprawcy;
		this.DatRozp=DatRozp;	
		this.DatZak=DatZak;
		this.StatSpraw=StatSpraw;
		this.RodzSzkody=RodzSzkody;
		this.Uwagi= Uwagi;
	}

	public Integer getIdSprawy() {
		return idSprawy;
	}

	public void setIdSprawy(Integer idSprawy) {
		this.idSprawy = idSprawy;
	}

	public String getDanPoszk() {
		return DanPoszk;
	}

	public void setDanPoszk(String danPoszk) {
		DanPoszk = danPoszk;
	}

	public String getDanSprawcy() {
		return DanSprawcy;
	}

	public void setDanSprawcy(String danSprawcy) {
		DanSprawcy = danSprawcy;
	}

	public String getDatRozp() {
		return DatRozp;
	}

	public void setDatRozp(String datRozp) {
		DatRozp = datRozp;
	}

	public String getDatZak() {
		return DatZak;
	}

	public void setDatZak(String datZak) {
		DatZak = datZak;
	}

	public String getStatSpraw() {
		return StatSpraw;
	}

	public void setStatSpraw(String statSpraw) {
		StatSpraw = statSpraw;
	}

	public String getRodzSzkody() {
		return RodzSzkody;
	}

	public void setRodzSzkody(String rodzSzkody) {
		RodzSzkody = rodzSzkody;
	}

	public String getUwagi() {
		return Uwagi;
	}

	public void setUwagi(String uwagi) {
		Uwagi = uwagi;
	}
}
