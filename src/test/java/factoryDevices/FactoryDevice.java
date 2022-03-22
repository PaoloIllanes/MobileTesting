package factoryDevices;

import java.util.Locale;

public class FactoryDevice {


        public static IDevice make(String deviceType){
            IDevice device;

            switch (deviceType.toLowerCase()){
                case "android":
                    device= new Android();
                    break;
                case "ios":
                    device= new Ios();
                    break;
                default:
                    device= new WindowsPhone();
                    break;
            }
            return device;
        }
    }


