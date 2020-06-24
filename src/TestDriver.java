import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

public class TestDriver {

	private static final List<String> SERVICE_TYPE_LIST =Arrays.asList(new String[] {"FS", "IOP"});
			
	public static void main(String[] args) {
		Integer partnerId = null;
		String realmId = "abc";
		if(partnerId == null) {
			partnerId = -1;
		}
		System.out.println(companyExists(-1, realmId));
		System.out.println(companyExists(26, realmId));
		System.out.println(companyExists(13, realmId));

	}



	private static boolean companyExists(int partnerId, String realmId) {
		Long longPartnerId = new Long(partnerId);
		Long companyId;
		System.out.println("companyExists: longPartnerId:"+ longPartnerId);

		List<Long> partnerIdList = null;

		//PartnerId = -1 is explicitly set in the QboCompanyExistsAction, when the PAPI is CompanyExists API is called without a PartnerId.
		if (partnerId != PartnerConstants.NUll_PARTNER_ID ) {
			partnerIdList = isQBOSSOPartner(longPartnerId) ? getQBOSSOPartnerIds() : Arrays.asList(new Long(longPartnerId));
		} else {
			partnerIdList = Arrays.asList(PartnerConstants.ALL_ACTIVE_PARTNER);
		}

		System.out.println("companyExists: Array is made:"+ Arrays.toString(partnerIdList.toArray()));

		companyId = getCompanyIdByRealmId(partnerIdList, realmId, SERVICE_TYPE_LIST);

		if (companyId == null) {
			System.out.println("companyExists: Payroll company does NOT exist.");
		}

		return companyId != null;
	}



	private static Long getCompanyIdByRealmId(List<Long> partnerIdList, String realmId, List<String> serviceTypeList) {
		return new Random().nextLong();
	}



	private static List<Long> getQBOSSOPartnerIds() {
		List<Long> partnerIdList = new ArrayList<>();
		partnerIdList.add(PartnerConstants.QBOSSO);
		partnerIdList.add(PartnerConstants.QBOSSOCOSTCO);
		return partnerIdList;
	}



	private static boolean isQBOSSOPartner(Long longPartnerId) {
		return longPartnerId == PartnerConstants.QBOSSO || longPartnerId == PartnerConstants.QBOSSOCOSTCO;
	}



	static final class PartnerConstants {

	    // Partner enums - see class javadoc above.
		public static final long PAYCYCLE = 1;
	    public static final long AFFILIATES = 5;
	    public static final long PREMIUM_PILOT = 6;
	    public static final long QBOE = 7;
	    public static final long HRBLOCK = 8;
	    public static final long VCP = 9;
	    public static final long GOVCOM = 10;
	    public static final long DI = 11;
	    public static final long QUICKBOOKSFORMACINTOSH = 12;
	    public static final long MANAGEPAYROLL = 13;
	    public static final long MYPROFITKEEPER = 14;
	    public static final long BANKOFAMERICA_G1 = 15; // Legacy partner for first
	    // generation BOA customers
		public static final long BANKOFAMERICA = 17;
	    public static final long PNC = 20;
	    public static final long VCP_2008 = 19;
	    public static final long VersaCheck = 666;
	    public static final long InstantChecks = 667;
	    public static final long IOPSSO = 24;
	    public static final long QBOSSO = 26;
	    public static final long COSTCO = 27;
	    public static final long WorkplaceSSO = 28;
	    public static final long IFSSSO = 29;
	    public static final long QBOSSOCOSTCO = 30;
	    public static final long[] AllPartners = {PAYCYCLE, IOPSSO, QBOSSO, QBOSSOCOSTCO, QUICKBOOKSFORMACINTOSH, QBOE, MANAGEPAYROLL, WorkplaceSSO, IFSSSO,
	                                              COSTCO, BANKOFAMERICA, PNC,
	                                              PREMIUM_PILOT, HRBLOCK, VCP, GOVCOM, AFFILIATES, MYPROFITKEEPER,
	                                              VCP_2008, VersaCheck, InstantChecks, BANKOFAMERICA_G1 };
	    public static final long BANKOFAMERICA_G3 = 31;
	    // Don't use Microsoft enums directly -- use isMoneyPartner() or
	    // isMicrosoft() instead.
	    public static final int MSMONEY = 2;
	    public static final int MSN = 3;
	    public static final int MSMONEY07 = 16;
	    public static final int MSMONEY08 = 18;
	    public static final String MANAGEPAYROLL_SOURCECODE = "MP";
	    public static final String ALL_PARTNERS = "ALL";

	    // Handles Null PartnerId in request param for PAPI Calls.
	    public static final int NUll_PARTNER_ID = -1;
	    // All active partner Ids.
	    public static Long[] ALL_ACTIVE_PARTNER = new Long[]{PAYCYCLE, Long.valueOf(MSN), QUICKBOOKSFORMACINTOSH, MANAGEPAYROLL, MYPROFITKEEPER,
	            PNC, IOPSSO, QBOSSO, COSTCO, WorkplaceSSO, IFSSSO, QBOSSOCOSTCO, BANKOFAMERICA_G3};

	    //CS-Ops Background images
	    public static final String IMG_CS = "csBackground.gif";
	    public static final String IMG_OPS = "opsBackground.png";


	    public static final String IMG_CS_LINEUP_CORE_PAYROLL_FIRST = "Lineup_Core_PayrollFirst_CSBackground.png";
	    public static final String IMG_OPS_LINEUP_CORE_PAYROLL_FIRST = "Lineup_Core_PayrollFirst_OPSBackground.png";
	    public static final String IMG_CS_LINEUP_PREMIUM_PAYROLL_FIRST = "Lineup_Premium_PayrollFirst_CSBackground.png";
	    public static final String IMG_OPS_LINEUP_PREMIUM_PAYROLL_FIRST = "Lineup_Premium_PayrollFirst_OPSBackground.png";
	    public static final String IMG_CS_LINEUP_ELITE_PAYROLL_FIRST = "Lineup_Elite_PayrollFirst_CSBackground.png";
	    public static final String IMG_OPS_LINEUP_ELITE_PAYROLL_FIRST = "Lineup_Elite_PayrollFirst_OPSBackground.png";

	    public static final String IMG_CS_LINEUP_CORE = "Lineup_Core_CSBackground.png";
	    public static final String IMG_OPS_LINEUP_CORE = "Lineup_Core_OPSBackground.png";
	    public static final String IMG_CS_LINEUP_PREMIUM = "Lineup_Premium_CSBackground.png";
	    public static final String IMG_OPS_LINEUP_PREMIUM = "Lineup_Premium_OPSBackground.png";
	    public static final String IMG_CS_LINEUP_ELITE = "Lineup_Elite_CSBackground.png";
	    public static final String IMG_OPS_LINEUP_ELITE = "Lineup_Elite_OPSBackground.png";

	    public static final String IMG_CS_QBFSP = "QBFSP_CS.png";
	    public static final String IMG_OPS_QBFSP = "QBFSP_OPS.png";
	    public static final String IMG_CS_QBOP = "QBOP_CS.png";
	    public static final String IMG_OPS_QBOP = "QBOP_OPS.png";

	    public static final String IMG_CS_CONTRACTOR_PAYMENTS = "csBackground_contractorPayments.gif";
	    public static final String IMG_OPS_CONTRACTOR_PAYMENTS = "opsBackground_contractorPayments.gif";

	    public static final String IMG_CS_COSTCO = "csBackground_COSTCO.gif";
	    public static final String IMG_OPS_COSTCO = "opsBackground_COSTCO.gif";

	    public static final String IMG_CS_HARMONY = "csBackground_Harmony.gif";
	    public static final String IMG_OPS_HARMONY = "opsBackground_Harmony.gif";


	    public static final String IMG_FULLSERVICE_ACCOUNTANT_CS = "csBackground_FS_AC.gif";
	    public static final String IMG_FULLSERVICE_ACCOUNTANT_OPS = "opsBackground_FS_AC.png";

	    public static final String IMG_FULLSERVICE_CS = "csBackground_FS.gif";
	    public static final String IMG_FULLSERVICE_OPS = "opsBackground_FS.png";

	    public static final String COMPANY_SRC_CODE_CTCOB = "Ctcob";
	    public static final String COMPANY_SRC_CODE_CTCOE = "Ctcoe";

	    private PartnerConstants(){}
	}
}
