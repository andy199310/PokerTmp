
import java.util.Random;
import java.util.Timer;

import com.weigreen.ncu.tfh.bridge.TFHBridgeMain;

public class TFHServerRoom implements Runnable
{
    private int peopleNumber = 0;
    private int questionNumber;
    private int roomPort;
    private long[] playerList;

    private int nowPlayingNumber;

    private final Random generator = new Random();
    private Timer timer;

    //	private TMHServerRoomSecondTask secondTask;
//	private TMHServerRoomDatabase database;
    private TFHServerRoomListener server;

    private TFHServerDatabase db;

    public TFHServerRoom(int port, String roomName, TFHServerDatabase db)
    {
        server = new TFHServerRoomListener(port, this, db);
        new Thread(server).start();

        roomPort = port;
        playerList = new long[3];
        //database = new TMHServerRoomDatabase();

        //timer = new Timer();
        //secondTask = new TFHServerRoomSecondTask(database, this, port);

        //timer.schedule(secondTask, 0, 1000);
    }

    public void haveNewData(TFHBridgeMain main)
    {
        short command = main.getCommand();
        long userId = main.getUserId();
		
/*		if(command == TFHComm.ROOM_NEW_PLAYER)
		{
			
			playerList[peopleNumber++] = userId;
			System.out.println("P:"+peopleNumber);
		}
		
		if(command == TFHComm.ROOM_DATA)
		{
			TMHBridgeDataPlayer playerData = (TMHBridgeDataPlayer) main.getData();
			
			int playerNumber = playerData.getPlayerNumber();
			int playerAnswer = playerData.getPlayerAnswer();
			
			if(judge(playerAnswer)) // correct answer
			{
				int newPlayerNumber = changePlayerNumber(playerNumber);
				nowPlayingNumber = newPlayerNumber;
				int newQuestionNumber  = changeQuestionNumber(questionNumber);
				questionNumber = newQuestionNumber;
				
				TMHBridgeDataRoom roomData = new TMHBridgeDataRoom("RIGHT", newPlayerNumber, newQuestionNumber, secondTask.getSeconds(), playerList);
				TMHBridgeMain newMain = new TMHBridgeMain(TMHComm.ROOM_DATA, 1, roomData);
				
				server.sendToAll(newMain);
			}
			else // wrong answer
			{
				TMHBridgeDataRoom roomData = new TMHBridgeDataRoom("WRONG", playerNumber, questionNumber, secondTask.getSeconds(), playerList);
				TMHBridgeMain newMain = new TMHBridgeMain(TMHComm.ROOM_DATA, 1, roomData);
				
				server.sendToAll(newMain);
			}
			
		}
		
		
		*/
    } // end method haveNewData



    /*	public boolean judge(int playerAnswer)
        {


            if (playerAnswer == database.getQuestionAnswer(questionNumber))
            {
                return true;
            }
            else
            {
                return false;
            }

        }


        public void start(int questionNumber, int second)
        {
            int initialPlyaerNumber = generator.nextInt(3);
            nowPlayingNumber = initialPlyaerNumber;

            this.questionNumber = questionNumber;

            TMHBridgeDataRoom roomData = new TMHBridgeDataRoom("START", initialPlyaerNumber, questionNumber, second, playerList);
            TMHBridgeMain newMain = new TMHBridgeMain(TMHComm.ROOM_DATA, 1, roomData);

            server.sendToAll(newMain);
        }


        public void boom()
        {
            TMHBridgeDataRoom roomData = new TMHBridgeDataRoom("BOOM", nowPlayingNumber, 0, -100, playerList);
            TMHBridgeMain newMain = new TMHBridgeMain(TMHComm.ROOM_DATA, 1, roomData);

            timer.cancel();
            database.deleteRoom(roomPort);
            server.sendToAll(newMain);
            server.closeServer();
        }


        public int changePlayerNumber(int playerNumber)
        {
            int newPlayerNumber = generator.nextInt(3);

            while(playerNumber == newPlayerNumber)
            {
                newPlayerNumber = generator.nextInt(3);
            }

            return newPlayerNumber;
        }

        public int changeQuestionNumber(int questionNumber)
        {
            int questionAmount = database.getQuestionAmount();
            int newQuestionNumber = generator.nextInt(questionAmount) + 1;

            while(questionNumber == newQuestionNumber)
            {
                newQuestionNumber = generator.nextInt(questionAmount) + 1;
            }

            return newQuestionNumber;
        }



        public int getPeopleNumber()
        {
            return peopleNumber;
        }

        */
    @Override
    public void run()
    {

    }

}
