public class LaptopModel {
    private String modelId;
    private String processor;
    private String ram;
    private String hardDisk;
    private String RGB;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getRGB() {
        return RGB;
    }

    public void setRGB(String RGB) {
        this.RGB = RGB;
    }

    public LaptopModel(String modelId, String processor, String ram, String hardDisk, String rgb) {
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return new LaptopModel(this.modelId,this.processor,this.ram,this.hardDisk,this.RGB);
    }
    @Override
    public String toString() {
        return String.format(this.modelId + " " + this.processor + " " + this.ram + " " + this.hardDisk + " " +this.RGB);
    }
}
