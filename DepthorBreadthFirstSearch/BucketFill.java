package DepthorBreadthFirstSearch;

import java.util.ArrayList;

public class BucketFill {
	public void bucketFill(ArrayList<ArrayList<Integer>> image, int newColor, int x, int y){
		int m = image.size(), n = image.get(0).size();
		if (image.get(x).get(y) == newColor ) {
			return;
		}
		image.get(x).set(y, newColor);
		if (x > 0 && image.get(x-1).get(y) != newColor) {
			bucketFill(image, newColor, x-1, y);
		}
		
		if (y > 0 && image.get(x).get(y-1) != newColor) {
			bucketFill(image, newColor, x, y-1);
		}
		
		if (x < m-1 && image.get(x+1).get(y) != newColor) {
			bucketFill(image, newColor, x+1, y);
		}
		
		if (y < n-1 && image.get(x).get(y+1) != newColor) {
			bucketFill(image, newColor, x, y+1);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> image1 = new ArrayList<>();
		image1.add(1);
		image1.add(0);
		image1.add(1);
		ArrayList<Integer> image2 = new ArrayList<>();
		image2.add(1);
		image2.add(0);
		image2.add(1);
		ArrayList<ArrayList<Integer>> image = new ArrayList<>();
		image.add(image1);
		image.add(image2);
		BucketFill bucketFill = new BucketFill();
		bucketFill.bucketFill(image, 2, 1, 0);
		for (ArrayList<Integer> arrayList : image) {
			System.out.println(arrayList);
		}
	}
}
