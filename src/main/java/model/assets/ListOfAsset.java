package model.assets;

import java.util.Iterator;
import java.util.List;

public class ListOfAsset implements Iterable<Asset> {

    private List<Asset> assets;

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    @Override
    public Iterator<Asset> iterator() {
        return null;
    }
}
