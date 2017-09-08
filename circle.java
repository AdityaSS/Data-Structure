package Datastructure;

public class circle implements Comparable<circle> {
	double radius;

	public circle(double r) {
		radius = r;
	}

	@Override
	public int compareTo(circle o) {
		if (radius > o.radius)
			return 1;
		else if (radius == o.radius)
			return 0;
		else
			return -1;

	}

	public String toString() {
		return ("Radius: " + radius);
	}

}
