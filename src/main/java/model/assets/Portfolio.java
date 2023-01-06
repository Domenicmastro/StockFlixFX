package model.assets;

import model.User;

import java.util.Iterator;
import java.util.List;

public class Portfolio extends ListOfAsset {
    private List<Asset> portfolio;
    private User user;

    // bidirectional with user?

    @Override
    public Iterator<Asset> iterator() {
        return null;
    }
    //should really be list of PURCHASED asset
}
