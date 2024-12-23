package Models;

import java.util.ArrayList;
import java.util.List;

public class Booking {

   private String _bookingid;
   private String _pinkupAddress;
   private String _dropoffAddress;
   private String _pinkupDate;
   private String _dropoffDate;
   private String _idcard;
   private String _carId;

   public Booking() {
   }

   public Booking(String bookingId,
           String _pinkupAddress,
           String _dropoffAddress,
           String _pinkupDate,
           String _dropoffDate) 
   {
      
      this._bookingid = bookingId;
      this._pinkupAddress = _pinkupAddress;
      this._dropoffAddress = _dropoffAddress;
      this._pinkupDate = _pinkupDate;
      this._dropoffDate = _dropoffDate;
   }

   public Booking(String idcard, String carId,
           String _pinkupAddress,
           String _dropoffAddress,
           String _pinkupDate,
           String _dropoffDate) {
      this._idcard = idcard;
      this._carId = carId;
      this._pinkupAddress = _pinkupAddress;
      this._dropoffAddress = _dropoffAddress;
      this._pinkupDate = _pinkupDate;
      this._dropoffDate = _dropoffDate;
   }

   public Booking(String _pinkupAddress, String _dropoffAddress, String _pinkupDate, String _dropoffDate) {
      this._pinkupAddress = _pinkupAddress;
      this._dropoffAddress = _dropoffAddress;
      this._pinkupDate = _pinkupDate;
      this._dropoffDate = _dropoffDate;
   }

   public String getBookingid() {
      return _bookingid;
   }

   public String getIdcard() {
      return _idcard;
   }

   public String getCarId() {
      return _carId;
   }

   public String getPinkupAddress() {
      return _pinkupAddress;
   }

   public String getDropoffAddress() {
      return _dropoffAddress;
   }

   public String getPinkupDate() {
      return _pinkupDate;
   }

   public String getDropoffDate() {
      return _dropoffDate;
   }

}
