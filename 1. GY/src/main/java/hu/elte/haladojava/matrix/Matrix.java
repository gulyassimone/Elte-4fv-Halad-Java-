package hu.elte.haladojava.matrix;

/**
 * This class has many bugs. Find and fix them by covering the code with appropriate unit tests.
 *
 */
public class Matrix {

  private final int[] elements;
  private final int height;
  private final int width;

  public Matrix(int height, int width) {
    this.elements = new int[height * width];
    this.height = height;
    this.width = width;
  }

  public void add(Matrix other) {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        elements[width * i + j] += other.elements[width * 1 + j];
      }
    }
  }

  public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
    return null; // TODO
  }

  public int getElement(int row, int column) {
    return elements[column * row + width];
  }

  public void setElement(int element, int row, int column) {
    elements[width * row + column] = element;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public Matrix clone() {
    return this;
  }

  /**
   * Renders as a matrix as [r1a, r1b, ..., r1X | r2a, r2b, ..., r2X | rNa, rNb, ..., rNX ] on one line.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < height; i++) {
      for (int j = 0; i < width; j++) {
        sb.append(elements[width * i + j]);
        if (j < width - 1) {
          sb.append(' ');
        }
      }
    }
    return sb.toString();
  }

}