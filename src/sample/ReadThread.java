package sample;

import javafx.application.Platform;
import util.LoginDTO;

import java.io.IOException;

public class ReadThread implements Runnable {
    private static final long serialVersionUID = 0L;

    private final Thread thr;
    private final Main main;

    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                if (o != null) {

                    if(o instanceof  SenderClass) {
                        Platform.runLater(()->
                        {

                            SenderClass senderClass = (SenderClass) o;
                            System.out.println(senderClass.loginDTO.getUserName());
                            System.out.println(senderClass.loginDTO.isStatus());

                            if (senderClass.loginDTO.isStatus()) {
                                try {
                                    System.out.println(senderClass.movieList.size());
                                    main.showHomePage(senderClass);


                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }

                            } else {
                                main.showAlert();
                            }
                        });


                    }



                    else if(o instanceof TransferMovie)
                    {
                            Platform.runLater(() -> {
                                TransferMovie transferMovie=(TransferMovie) o;
                                Main.CompanyMovieList=transferMovie.getMovieList();
                                SenderClass senderClass=new SenderClass();
                                senderClass.setMovieList(transferMovie.getMovieList());
                                System.out.println(senderClass.getMovieList().get(0).getProductionCompany()+"should be Paramount Pictures");
                                try {
                                    main.showHomePage(senderClass);


                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            });

                    }




//                    if (o instanceof LoginDTO) {
//                        LoginDTO loginDTO = (LoginDTO) o;
//                        System.out.println(loginDTO.getUserName());
//                        System.out.println(loginDTO.isStatus());
//                        // the following is necessary to update JavaFX UI components from user created threads
//                        Platform.runLater(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (loginDTO.isStatus()) {
//                                    try {
//                                        main.showHomePage(loginDTO.getUserName());
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    }
//                                } else {
//                                    main.showAlert();
//                                }
//
//                            }
//                        });
//                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        }
    }




