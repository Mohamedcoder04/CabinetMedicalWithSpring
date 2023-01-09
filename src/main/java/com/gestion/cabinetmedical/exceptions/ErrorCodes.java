package com.gestion.cabinetmedical.exceptions;

public enum ErrorCodes {
        CONSULTATION_NOT_FOUND(1000),
        CONSULTATION_NOT_VALID(1001),

        MEDECIN_NOT_FOUND(2000),
        MEDECIN_NOT_VALID(2001),

        MEDICAMENT_NOT_FOUND(3000),
        MEDICAMENT_NOT_VALID(3001),

        ORDONNANCE_NOT_FOUND(4000),
        ORDONNANCE_NOT_VALID(4001),

        PATIENT_NOT_FOUND(5000),
        PATIENT_NOT_VALID(5001),

        RENDEZVOUS_NOT_FOUND(6000),
        RENDEZVOUS_NOT_VALID(6001),

        SECRETAIRE_NOT_FOUND(7000),
        SECRETAIRE_NOT_VALID(7001),
    ;

    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
