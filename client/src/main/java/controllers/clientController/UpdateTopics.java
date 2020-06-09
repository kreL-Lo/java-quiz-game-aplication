package controllers.clientController;

import controllers.server.GetTopicsController;
import graphics.lobby.LobbyPanel;
import graphics.lobby.StructurePanel;
import graphics.lobby.TopicPanel;
import models.server.TopicsType;

public class UpdateTopics {
    public static void updateTopics (StructurePanel structurePanel, String token){

        LobbyPanel lobbyPanel = structurePanel.getLobbyPanel();
        if(lobbyPanel!=null)
            structurePanel.remove(lobbyPanel);

        lobbyPanel = new LobbyPanel(structurePanel.getMainFrame());
        structurePanel.setLobbyPanel(lobbyPanel);
        TopicsType topicsType =  GetTopicsController.getTopics();
        TopicPanel [] topics = new TopicPanel[topicsType.getTopics().size()];
        int i =0;
        for(String topic:topicsType.getTopics()){
            topics[i] = new TopicPanel(
                    structurePanel.getMainFrame(),
                    lobbyPanel,topic );
                    lobbyPanel.add(topics[i]);
            ++i;
        }
        structurePanel.add(lobbyPanel);
        structurePanel.validate();
        structurePanel.repaint();
    }
}
