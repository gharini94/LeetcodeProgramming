public class Diskspace {
	public int analyse(int numComputer, int[] hardDiskSpace, int segmentLength) {
		Deque deq = new ArrayDeque<>();
		int maxMin = Integer.MIN_VALUE;
		for(int i = 0; i < numComputer; i++) {
			while(!deq.isEmpty() && hardDiskSpace[deq.peekLast()] > hardDiskSpace[i]) {
				deq.pollLast();
			}
			if(!deq.isEmpty() && deq.peekFirst() <= (i - segmentLength)) {
				deq.pollFirst();
			}
			deq.offerLast(i);
			if(i >= (segmentLength - 1)) {
				maxMin = Math.max(maxMin, hardDiskSpace[deq.peekFirst()]);
		}
	}
	return maxMin;
}