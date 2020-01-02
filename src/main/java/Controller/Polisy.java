package Controller;

public class Polisy {
	Integer idPolisy,Klient_idKlient;
	String DataOd,DataDo,TowUbez,NazPolisy,NrRej,DanUbez,IleRat,Koszt,Uwagi;

	public Polisy(Integer idPolisy, String DataOd , String DataDo, String TowUbez,String NazPolisy,String NrRej,String DanUbez,String IleRat,String Koszt,String Uwagi,Integer Klient_idKlient) {
		this.idPolisy= idPolisy;
		this.DataOd=DataOd;
	    this.DataDo=DataDo;
		this.TowUbez=TowUbez;	
		this.NazPolisy=NazPolisy;
		this.NrRej=NrRej;
		this.DanUbez=DanUbez;
		this.IleRat= IleRat;
		this.Koszt=Koszt;
		this.Uwagi=Uwagi;
		this.Klient_idKlient=Klient_idKlient;
	}

	public Integer getIdPolisy() {
		return idPolisy;
	}

	public void setIdPolisy(Integer idPolisy) {
		this.idPolisy = idPolisy;
	}

	public Integer getKlient_idKlient() {
		return Klient_idKlient;
	}

	public void setKlient_idKlient(Integer klient_idKlient) {
		Klient_idKlient = klient_idKlient;
	}

	public String getUwagi() {
		return Uwagi;
	}

	public void setUwagi(String uwagi) {
		Uwagi = uwagi;
	}

	

	public String getDataOd() {
		return DataOd;
	}

	public void setDataOd(String dataOd) {
		DataOd = dataOd;
	}

	public String getDataDo() {
		return DataDo;
	}

	public void setDataDo(String dataDo) {
		DataDo = dataDo;
	}

	public String getTowUbez() {
		return TowUbez;
	}

	public void setTowUbez(String towUbez) {
		TowUbez = towUbez;
	}

	public String getNazPolisy() {
		return NazPolisy;
	}

	public void setNazPolisy(String nazPolisy) {
		NazPolisy = nazPolisy;
	}

	public String getNrRej() {
		return NrRej;
	}

	public void setNrRej(String nrRej) {
		NrRej = nrRej;
	}

	public String getDanUbez() {
		return DanUbez;
	}

	public void setDanUbez(String danUbez) {
		DanUbez = danUbez;
	}

	public String getIleRat() {
		return IleRat;
	}

	public void setIleRat(String ileRat) {
		IleRat = ileRat;
	}

	public String getKoszt() {
		return Koszt;
	}

	public void setKoszt(String koszt) {
		Koszt = koszt;
	}

}
