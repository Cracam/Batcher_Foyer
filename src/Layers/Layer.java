/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layers;

import java.util.logging.Logger;

/**
 *
 * @author LECOURT Camille
 */
public class Layer {
        private String name;

   
        private float pos_x;
        private float pos_y;
        private float size_x;
        private float size_y;
        
        private String imagename;
        //Obj image retour
        //private Image ressource;

        
        
        public Layer(String name, float pos_x, float pos_y, float size_x, float size_y) {
            this.name = name;
            this.pos_x = pos_x;
            this.pos_y = pos_y;
            this.size_x = size_x;
            this.size_y = size_y;
        }

    public Layer(String name, float pos_x, float pos_y, float size_x, float size_y, String imagename) {
        this.name = name;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.size_x = size_x;
        this.size_y = size_y;
        this.imagename = imagename;
    }

        

         
        
         
        
        
        
       
        
        public void setImagename(String imagename) {
            this.imagename = imagename;
        }
   
        
        public String getName() {
            return name;
        }
        
        public void LoadImage(){
            
        }
        
}
