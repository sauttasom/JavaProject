/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class Cars {

   public int getCarid() {
      return carid;
   }

   public String getPathimage() {
      return pathimage;
   }

   public String getCarname() {
      return carname;
   }

   public String getCarPirce() {
      return carPirce;
   }

   public String getImageName() {
      return imageName;
   }

   private int carid;
   private String pathimage;
   private String carname;
   private String carPirce;
   private String imageName;

   public Cars() {
   }

   public Cars(int carid, String pathimage, String carname, String carPirce, String imageName) {
      this.carid = carid;
      this.pathimage = pathimage;
      this.carname = carname;
      this.carPirce = carPirce;
      this.imageName = imageName;
   }
}
