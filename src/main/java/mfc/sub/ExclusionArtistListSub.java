package mfc.sub;

import java.io.Serializable;
import java.util.List;

import mfc.utilities.InstanceManager;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class ExclusionArtistListSub implements Serializable  {

    private static final long serialVersionUID = 113901923L;

    protected List<String> exclusionArtistList = InstanceManager.newAtomicList();

    public List<String> getExclusionArtistList() {
        return exclusionArtistList;
    }

    public void addExclusionArtistList(final String exclusionArtist) {
        this.exclusionArtistList.add(exclusionArtist);
    }


}
