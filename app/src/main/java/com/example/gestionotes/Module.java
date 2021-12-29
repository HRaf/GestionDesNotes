package com.example.gestionotes;

public class Module {
    private String moduleName;
    private Double moduleNote;

    public Module(String moduleName, Double moduleNote) {
        this.moduleName = moduleName;
        this.moduleNote = moduleNote;
    }

    public Module() {
    }

    public String getModuleName() {
        return moduleName;
    }

    public Double getModuleNote() {
        return moduleNote;
    }
}
