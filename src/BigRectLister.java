import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

    // Rectangle filter
    class BigRectangleFilter implements Filter<Rectangle> {
        @Override
        public boolean accept(Rectangle rectangle) {
            return (rectangle.width + rectangle.height) * 2 > 10;
        }
    }

    public class BigRectLister {
        public static void main(String[] args) {
            List<Rectangle> rectangles = new ArrayList<>();

            // making rectangles, some big some small
            rectangles.add(new Rectangle(1, 1));
            rectangles.add(new Rectangle(2, 2));
            rectangles.add(new Rectangle(3, 3));
            rectangles.add(new Rectangle(2, 3));
            rectangles.add(new Rectangle(6, 9));
            rectangles.add(new Rectangle(1, 2));
            rectangles.add(new Rectangle(7, 7));
            rectangles.add(new Rectangle(2, 4));
            rectangles.add(new Rectangle(9, 7));
            rectangles.add(new Rectangle(3, 1));

            // Filtering out rectangles with big perimeters using collect all
            List<Rectangle> bigRectangles = collectAll(rectangles, new BigRectangleFilter());

            //sout
            System.out.println("Rectangles with big perimeters (>10):");
            for (Rectangle rectangle : bigRectangles) {
                System.out.println(rectangle);
            }
        }

        // Methods for collecting rectangles and filtering out the large ones
        public static <T> List<T> collectAll(List<T> list, Filter<T> filter) {
            List<T> filteredList = new ArrayList<>();
            for (T item : list) {
                if (filter.accept(item)) {
                    filteredList.add(item);
                }
            }
            return filteredList;
        }
    }

