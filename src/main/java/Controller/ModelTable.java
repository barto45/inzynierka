package Controller;

public class ModelTable {
	Integer idKlient;
	String Nazwa,Ulica,Kod_Poczt,Nr_tel,Nip,Pesel,Miejscowosc,NrDomu;

	public ModelTable(Integer idKlient, String Nazwa , String Ulica, String Kod_Poczt,String Nr_tel,String Nip,String Pesel, String Miejscowosc,String NrDomu) {
		this.idKlient= idKlient;
		this.Nazwa=Nazwa;
	    this.Ulica=Ulica;
		this.Kod_Poczt=Kod_Poczt;	
		this.Nr_tel=Nr_tel;
		this.Nip=Nip;
		this.Pesel=Pesel;
		this.Miejscowosc= Miejscowosc;
		this.NrDomu=NrDomu;
	}

	public Integer getIdKlient() {
		return idKlient;
	}

	public void setIdKlient(Integer idKlient) {
		this.idKlient = idKlient;
	}

	public String getNazwa() {
		return Nazwa;
	}

	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}

	public String getUlica() {
		return Ulica;
	}

	public void setUlica(String ulica) {
		Ulica = ulica;
	}

	public String getKod_Poczt() {
		return Kod_Poczt;
	}

	public void setKod_Poczt(String kod_Poczt) {
		Kod_Poczt = kod_Poczt;
	}

	public String getNr_tel() {
		return Nr_tel;
	}

	public void setNr_tel(String nr_tel) {
		Nr_tel = nr_tel;
	}

	public String getNip() {
		return Nip;
	}

	public void setNip(String nip) {
		Nip = nip;
	}

	public String getPesel() {
		return Pesel;
	}

	public void setPesel(String pesel) {
		Pesel = pesel;
	}

	public String getMiejscowosc() {
		return Miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		Miejscowosc = miejscowosc;
	}

	public String getNrDomu() {
		return NrDomu;
	}

	public void setNrDomu(String nrDomu) {
		NrDomu = nrDomu;
	}
	
}
