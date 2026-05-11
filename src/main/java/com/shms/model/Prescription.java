	package com.shms.model;
	import jakarta.persistence.*;

	@Entity
	@Table(name = "prescriptions")
	public class Prescription {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "prescription_id")
	    private int prescriptionId;

	    private int patientId;

	    private int doctorId;

	    private String medicines;

	    private String notes;

	    // Getters and Setters

	    public int getPrescriptionId() {
	        return prescriptionId;
	    }

	    public void setPrescriptionId(int prescriptionId) {
	        this.prescriptionId = prescriptionId;
	    }

	    public int getPatientId() {
	        return patientId;
	    }

	    public void setPatientId(int patientId) {
	        this.patientId = patientId;
	    }

	    public int getDoctorId() {
	        return doctorId;
	    }

	    public void setDoctorId(int doctorId) {
	        this.doctorId = doctorId;
	    }

	    public String getMedicines() {
	        return medicines;
	    }

	    public void setMedicines(String medicines) {
	        this.medicines = medicines;
	    }

	    public String getNotes() {
	        return notes;
	    }

	    public void setNotes(String notes) {
	        this.notes = notes;
	    }

}
