package soa.model;
// Generated Mar 26, 2022, 9:28:10 PM by Hibernate Tools 5.5.7.Final

/**
 * Medicinedetail generated by hbm2java
 */
public class Medicinedetail implements java.io.Serializable {

	private Integer medicineDetailId;
	private Doctor doctor;
	private Medicine medicine;
	private int medicineAmount;
	private Double medicineTotalPrice;

	public Medicinedetail() {
	}

	public Medicinedetail(Doctor doctor, Medicine medicine, int medicineAmount) {
		this.doctor = doctor;
		this.medicine = medicine;
		this.medicineAmount = medicineAmount;
	}

	public Medicinedetail(Doctor doctor, Medicine medicine, int medicineAmount, Double medicineTotalPrice) {
		this.doctor = doctor;
		this.medicine = medicine;
		this.medicineAmount = medicineAmount;
		this.medicineTotalPrice = medicineTotalPrice;
	}

	public Integer getMedicineDetailId() {
		return this.medicineDetailId;
	}

	public void setMedicineDetailId(Integer medicineDetailId) {
		this.medicineDetailId = medicineDetailId;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Medicine getMedicine() {
		return this.medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public int getMedicineAmount() {
		return this.medicineAmount;
	}

	public void setMedicineAmount(int medicineAmount) {
		this.medicineAmount = medicineAmount;
	}

	public Double getMedicineTotalPrice() {
		return this.medicineTotalPrice;
	}

	public void setMedicineTotalPrice(Double medicineTotalPrice) {
		this.medicineTotalPrice = medicineTotalPrice;
	}

}
