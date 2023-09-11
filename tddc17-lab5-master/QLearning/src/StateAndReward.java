public class StateAndReward {
	

	
	/* State discretization function for the angle controller */
	public static String getStateAngle(double angle, double vx, double vy) {
		return "angle:" + StateAndReward.discretize2(angle, 10, -2, 2);
	}

	/* Reward function for the angle controller */
	public static double getRewardAngle(double angle, double vx, double vy) {		
		 
		double reward = -Math.abs(angle)/Math.PI;
	    return reward;
	}

	/* State discretization function for the full hover controller */
	public static String getStateHover(double angle, double vx, double vy) {
	
	}

	/* Reward function for the full hover controller */
	public static double getRewardHover(double angle, double vx, double vy) {	
		
		
		
	}
	
	


	public static int discretize(double value, int nrValues, double min,
			double max) {
		if (nrValues < 2) {
			return 0;
		}

		double diff = max - min;

		if (value < min) {
			return 0;
		}
		if (value > max) {
			return nrValues - 1;
		}

		double tempValue = value - min;
		double ratio = tempValue / diff;

		return (int) (ratio * (nrValues - 2)) + 1;
	}

	
	public static int discretize2(double value, int nrValues, double min,
			double max) {
		double diff = max - min;

		if (value < min) {
			return 0;
		}
		if (value > max) {
			return nrValues - 1;
		}

		double tempValue = value - min;
		double ratio = tempValue / diff;

		return (int) (ratio * nrValues);
	}

}
