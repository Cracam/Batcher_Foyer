/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layers;

/**
 * This class is a layer wich is color will be changed by the user of the app using the interface tab "Couleurs"
 * @author LECOURT Camille
 */
public class LayerColor extends Layer{

    public LayerColor(String name, float pos_x, float pos_y, float size_x, float size_y) {
        super(name, pos_x, pos_y, size_x, size_y);
    }

    public LayerColor(String name, float pos_x, float pos_y, float size_x, float size_y, String imagename) {
        super(name, pos_x, pos_y, size_x, size_y, imagename);
    }
        
    
        
}
