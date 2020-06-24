package Jun20;

public class TestCode {

	private static String m_exportDestination;
	private static int m_exportDestinationID;

	public static void main(String[] args) {
		System.out.println(getExportDestination());
	}

	
	public static String getExportDestination() {
        if (m_exportDestination == null) {
            // ensure that exportDestination is set
            if (m_exportDestinationID != 0) {
                m_exportDestination = Integer.toString(m_exportDestinationID);
            }
            else {
                // Return empty string if not set
                 return "";
            }
        }
        m_exportDestination = Integer.toString(m_exportDestinationID);
        return m_exportDestination;
    }
}
