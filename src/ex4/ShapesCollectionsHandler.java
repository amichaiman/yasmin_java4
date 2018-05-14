package ex4;

import ex4.exceptionsTypes.BaseShapeNumArgException;
import ex4.exceptionsTypes.BaseShapeTypeException;
import ex4.exceptionsTypes.NonPositiveValueException;
import ex4.exceptionsTypes.ShapeTypeException;

import java.io.*;
import java.util.*;

public class ShapesCollectionsHandler  {
	public static void main(String[] argv) throws IOException{
		String fileName1="./src/ex4/shapesIn.txt"; //shapesIn path
		List<PrismPyramid> array_list = new ArrayList<>(); //an array list of PrismPyramid
		Map<Double,List<PrismPyramid>> map = new TreeMap<>();
		double height;

		try {
			Scanner sc = new Scanner(new File(fileName1));
			String theLines;

			while (sc.hasNextLine()) //if we've got another line
			{
				theLines = sc.nextLine();
				String[] array = theLines.split("\t");

				if (array[0].compareTo("y") == 0) //if the first letter is y then its a pyramid
				{
					height = Double.parseDouble(array[1]); //we get it's height
					if (array[2].compareTo("t") == 0) //then we check if it's of base triangle or rectangle
					{
						String[] lines = array[3].split(",");
						if (lines.length != 3) {
							throw new BaseShapeNumArgException(theLines);
						}
						double first = Double.parseDouble(lines[0]); //the triangle's sides length
						double second = Double.parseDouble(lines[1]);
						double third = Double.parseDouble(lines[2]);

						array_list.add(0, new Pyramid(new Triangle(first, second, third), height)); //a pyramid of base triangle

					} else if (array[2].compareTo("r") == 0) //it's a rectangle
					{
						String[] lines = array[3].split(",");  //we get the rectangle's height and width
						if (lines.length != 2) {
							throw new BaseShapeNumArgException(theLines);
						}
				
						double first = Double.parseDouble(lines[0]);
						double second = Double.parseDouble(lines[1]);
						array_list.add(0, new Pyramid(new Rectangle(first, second), height)); //we've a pyramid of base rectangle
					} else {
						throw new BaseShapeTypeException(theLines);
					}


				}

				if (array[0].compareTo("r") == 0)  //if it's a Prism
				{
					height = Double.parseDouble(array[1]); //we get it's height

					if (array[2].compareTo("t") == 0) //then if it's of base triangle we get the length of it's sides
					{
						String[] lines = array[3].split(",");
						
						if (lines.length != 3) {
							throw new BaseShapeNumArgException(theLines);
						}
						
						double first = Double.parseDouble(lines[0]);
						double second = Double.parseDouble(lines[1]);
						double third = Double.parseDouble(lines[2]);
						try {
							array_list.add(0, new Prism(new Triangle(first, second, third), height)); //prism of base triangle
						} catch (NonPositiveValueException e) {
							throw new NonPositiveValueException(theLines);
						}
					} else if (array[2].compareTo("r") == 0)  //the base is rectangle so we get it's height and width
					{
						String[] lines = array[3].split(",");
						
						if (lines.length != 2) {
							throw new BaseShapeNumArgException(theLines);
						}
						
						double first = Double.parseDouble(lines[0]);
						double second = Double.parseDouble(lines[1]);

						array_list.add(0, new Prism(new Rectangle(first, second), height)); //prism of base rectangle
					} else {
						System.out.println("Wrong Input, you should tybe r for rectangle or t for triangle");
					}


				} else {

					throw new ShapeTypeException(theLines);
				}
				if (!map.containsKey(array_list.get(0).volume())) {
					map.put(array_list.get(0).volume(), new ArrayList<PrismPyramid>());
				}
				map.get(array_list.get(0).volume()).add(array_list.get(0));
			}
			sc.close(); //we close the scanner

			//part b
			//1
			Writer wr = new FileWriter("./src/ex4//" + "shapesOut.txt");
			for (PrismPyramid p : array_list) {
				wr.write(p.toString() + "\n");
			}
			wr.flush();
			wr.close();//we are done of writing to file shapesOut.txt
			//2
			wr = new FileWriter("./src/ex4//" + "shapesSortOutMap.txt");  //the path of shapesOut where is our output

			for (Map.Entry<Double, List<PrismPyramid>> mapPair : map.entrySet()) {
				for (PrismPyramid p : mapPair.getValue()) {
					wr.write(p.toString() + "\n");
				}
			}
			wr.flush();
			wr.close();//we are done of writing to file shapesSortOutMap.txt

			//3
			wr = new FileWriter("./src/ex4//" + "shapesSortOutList.txt");  //the path of shapesOut where is our output

			ListIterator<PrismPyramid> li = array_list.listIterator(array_list.size());

			while (li.hasPrevious()) {
				wr.write(li.previous().toString());
				wr.write("\n");
			}
			wr.flush();
			wr.close();//we are done of writing to file shapesSortOutList.txt

		} catch (BaseShapeTypeException e){
			writeExceptionToFile("./src/ex4//"+"BaseTypeException.txt",e);
		} catch (ShapeTypeException e){
			writeExceptionToFile("./src/ex4//"+"ShapeTypeException.txt",e);
		} catch (BaseShapeNumArgException e) {
			writeExceptionToFile("./src/ex4//"+"BaseShapeNumArgException.txt",e);
		} //TODO: add non positive value excpeion
		
		
		catch (Exception e){
			Writer fw= new FileWriter("./src/ex4//"+"FileNotFoundException.txt");
			fw.write("file not found");
			fw.flush();
			fw.close();
		}



	}

	private static void writeExceptionToFile(String fileName, Exception e) throws IOException {
		Writer fw= new FileWriter(fileName);
		fw.write(e.getMessage());
		fw.flush();
		fw.close();
	}
}
