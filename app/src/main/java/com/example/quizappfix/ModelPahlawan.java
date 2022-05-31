package com.example.quizappfix;

class ModelPahlawan {
    String pahlawanEnsiklopedia;
    String detailPahlawan;
    int image;

    public ModelPahlawan(String pahlawanEnsiklopedia, int image, String detailPahlawan) {
        this.detailPahlawan = detailPahlawan;
        this.image = image;
        this.pahlawanEnsiklopedia = pahlawanEnsiklopedia;
        
    }

    public String getDetailPahlawan() {
        return detailPahlawan;
    }
    
    public int getImage() {
        return image;
    }

    public String getPahlawanEnsiklopedia() {
        return pahlawanEnsiklopedia;
    }
}
