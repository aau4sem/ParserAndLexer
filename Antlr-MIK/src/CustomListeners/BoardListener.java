package customListeners;

import gen.Tactic;
import gen.TacticBaseListener;
import model.utils.TypeCheckerHelper;

/** This class has the responsibility of keeping all data regarding the board. */
public class BoardListener extends TacticBaseListener {

    private String[] boardPaths = new String[0];


    /** This method will recognize only calls that will effect the board,
     * and save the given data.*/
    @Override
    public void exitArrayAssign(Tactic.ArrayAssignContext ctx) {
        if(ctx.identifier() != null){ //Format: identifier[number] = arrayExpr

            //Confirm the word for addressing the board. //TODO Change to be the right one.
            if(ctx.identifier().word().getText().compareTo("board_level") == 0){

                if(ctx.number().get(0).integer() == null){
                    System.out.println("Board array is being addressed with a float value!");
                    throw new IllegalArgumentException();
                }

                //Get the array index
                int index = TypeCheckerHelper.parseInt(ctx.number().get(0).integer().getText()); //This should be an int with the above check

                //Get the string that contains the path.

                if(ctx.arrayExpr(0).value() == null){
                    System.out.println("Board array path is not a value!");
                    throw new IllegalArgumentException();
                }

                if(ctx.arrayExpr(0).value().string() == null){
                    System.out.println("Board array path is not a string!");
                    throw new IllegalArgumentException();
                }

                String path = ctx.arrayExpr(0).value().string().getText().substring(1, ctx.arrayExpr(0).value().string().getText().length() -1);

                addPathToIndex(index, path);
            }

        }
    }

    /** Adds the given path to the given index. */
    private void addPathToIndex(int index, String path){
        if(boardPaths.length < index+1){
            String[] newBoardPaths = expandArray(boardPaths, index+1);
            newBoardPaths[index] = path;
            boardPaths = newBoardPaths;
        }else{
            boardPaths[index] = path;
        }
    }

    /** @return a new array of the given size with the elements of the given old array. */
    private String[] expandArray(String[] oldArray, int newSize){
        String[] newArray = new String[newSize];

        //Initialize
        for(String val : newArray)
            val = null;

        //Copy old values
        for(int i = 0; i < oldArray.length; i++)
            newArray[i] = oldArray[i];

        return newArray;
    }

    public String[] getBoardPaths() {
        return boardPaths;
    }
}
