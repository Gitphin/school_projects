
/*
 * This class makes use of the EasyBufferedImage to draw an image given a sparse integer matrix.
 * 
 * Chad Myers
 * chadm@umn.edu
 */

public class MatrixViewer {
	   
	/**e
     * Uses EasyBufferedImage class to display a sparse matrix as an image.
     * <p>
     * @param  SparseIntMatrix 
     * @return     none
     */
	public static void show(SparceIntMatrix matrix) {
		   int[][] pixels = new int[matrix.getNumRows()][matrix.getNumCols()];
		   for(int i=0; i< matrix.getNumRows(); i++) {
			   for(int j=0; j < matrix.getNumCols(); j++) {
				   pixels[i][j]=matrix.getElement(i, j);
			   }
		   }
		   EasyBufferedImage image = EasyBufferedImage.createImage(pixels);
		   image.show("Matrix View");
	   }
	
}
