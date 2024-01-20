package Business.Functions;

/**
 *
 * @author prasanna
 */
public class Location {
    private static int counter = 0;
    public static String[] getPinLocationForHelper(String networkName)
    {
        System.out.println("networkName"+networkName);
        String latitude = "42.3600825";
        String longitude= "-71.10325";
     if(networkName.equalsIgnoreCase("Boston"))
     {
      latitude = "42.3600825"; 
      longitude="-71.0588801";
      
     }
     else if(networkName.equalsIgnoreCase("Somerville"))
     {
       latitude = "42.3837569";  
       longitude="-71.10325";
     }
     else if(networkName.equalsIgnoreCase("Mumbai"))
     {
       latitude = "19.0759837";  
       longitude="72.8776559";
     }
     else if(networkName.equalsIgnoreCase("Hyderabad"))
     {
       latitude = "17.3850440";  
       longitude="78.4866710";
     }
      else if(networkName.equalsIgnoreCase("Memphis"))
     {
       latitude = "35.1495343";  
       longitude="-90.0489801";
     }
     else if(networkName.equalsIgnoreCase("Roxbury"))
     {
       latitude = "40.8693272";  
       longitude="-74.6634640";
     }
     else
     {
          latitude = "42.3600825";
          longitude= "-71.10325";
     }
     return new String[]{longitude,latitude};
    
    }
}
