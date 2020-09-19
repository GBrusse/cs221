import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class GridMonitor implements GridMonitorInterface {
	private double[][] grid;
	private int gridX, gridY;
	public GridMonitor(String fileName) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			return;
		}
		gridY = sc.nextInt();
		gridX = sc.nextInt();
		grid = new double[gridY][gridX];
		for (int y = 0; y < gridY; y++) {
			for (int x = 0; x < gridX; x++) {
				grid[y][x] = sc.nextDouble();
			}
		}
	}

	/**
	 * Returns the original base grid, as read from file.
	 * 
	 * @return base grid
	 */
	public double[][] getBaseGrid(){
		return grid;
	}
	
	/**
	 * Returns a grid with the same dimensions as the base grid, but each element
	 * is the sum of the 4 surrounding base elements. For elements on a grid border,
	 * the base element's own value is used when looking out of bounds, as if there
	 * is a mirror surrounding the grid. This method is exposed for testing.
	 * 
	 * @return grid containing the sum of adjacent positions
	 */
	public double[][] getSurroundingSumGrid(){
		double[][] sumGrid = new double[gridY][gridX];
		for (int y = 0; y < gridY; y++) {
			for (int x = 0; x < gridX; x++) {
				sumGrid[y][x] = 
						grid[Math.max(y-1,0)][x] + 
						grid[Math.min(y+1,gridY-1)][x] +
						grid[y][Math.max(x-1,0)] +
						grid[y][Math.min(x+1,gridX-1)];
			}
		}
		return sumGrid;
	}
	
	/**
	 * Returns a grid with the same dimensions as the base grid, but each element
	 * is the average of the 4 surrounding base elements. This method is exposed for 
	 * testing.
	 * 
	 * @return grid containing the average of adjacent positions
	 */
	public double[][] getSurroundingAvgGrid(){
		double[][] avgGrid = new double[gridY][gridX];
		for (int y = 0; y < gridY; y++) {
			for (int x = 0; x < gridX; x++) {
				avgGrid[y][x] = 
						(grid[Math.max(y-1,0)][x] + 
						grid[Math.min(y+1,gridY-1)][x] +
						grid[y][Math.max(x-1,0)] +
						grid[y][Math.min(x+1,gridX-1)])/4.0;
			}
		}
		return avgGrid;
	}
	
	/**
	 * Returns a grid with the same dimensions as the base grid, but each element 
	 * is the maximum delta from the average. For example, if the surrounding
	 * average at some coordinate is 2.0 and the maximum delta is 50% of the average,
	 * the delta value at the same coordinate in this grid will be 1.0. This method is
	 * exposed for testing.
	 * 
	 * @return grid containing the maximum delta from average of adjacent positions
	 */
	public double[][] getDeltaGrid(){
			double[][] deltaGrid = new double[gridY][gridX];
			for (int y = 0; y < gridY; y++) {
				for (int x = 0; x < gridX; x++) {
					deltaGrid[y][x] = 
							(grid[Math.max(y-1,0)][x] + 
							grid[Math.min(y+1,gridY-1)][x] +
							grid[y][Math.max(x-1,0)] +
							grid[y][Math.min(x+1,gridX-1)])/8.0;
				}
			}
			return deltaGrid;
	}

	/**
	 * Returns a grid with the same dimensions as the base grid, but each element
	 * is a boolean value indicating if the cell is at risk. For example, if the cell
	 * at a coordinate is less than the surrounding average minus its maximum delta or
	 * greater than the surrounding average plus its maximum delta, the corresponding
	 * coordinate in this grid will be true. If the base cell value is within the safe
	 * range, however, the corresponding value in this grid will be false.
	 * 
	 * @return grid containing boolean values indicating whether the cell at this
	 * location is in danger of exploding
	 */
	public boolean[][] getDangerGrid(){
		boolean[][] dangerGrid = new boolean[gridY][gridX];
		for (int y = 0; y < gridY; y++) {
			for (int x = 0; x < gridX; x++) {
				double avg = 
						(grid[Math.max(y-1,0)][x] + 
						grid[Math.min(y+1,gridY-1)][x] +
						grid[y][Math.max(x-1,0)] +
						grid[y][Math.min(x+1,gridX-1)])/4.0;
				double delta = Math.abs(avg/2.0);
				dangerGrid[y][x] = (grid[y][x] < avg - delta) || (grid[y][x] > avg + delta);
			}
		}
		return dangerGrid;
	}
}