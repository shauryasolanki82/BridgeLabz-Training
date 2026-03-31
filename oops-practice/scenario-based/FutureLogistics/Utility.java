public class Utility {

    public static boolean validateTransportId(String transportId) {
        return transportId.matches("RTS[0-9]{3}[A-Z]");
    }

    public static GoodsTransport parseDetails(String input) {
        String[] data = input.split(":");

        if (!validateTransportId(data[0])) {
            System.out.println("Transport id " + data[0] + " is invalid");
            System.out.println("Please provide a valid record");
            return null;
        }

        if (data[3].equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(
                    data[0], data[1], Integer.parseInt(data[2]),
                    Float.parseFloat(data[4]),
                    Integer.parseInt(data[5]),
                    Float.parseFloat(data[6])
            );
        } else {
            return new TimberTransport(
                    data[0], data[1], Integer.parseInt(data[2]),
                    Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]),
                    data[6],
                    Float.parseFloat(data[7])
            );
        }
    }

    public static String findObjectType(GoodsTransport gt) {
        if (gt instanceof BrickTransport)
            return "BrickTransport";
        else
            return "TimberTransport";
    }
}
