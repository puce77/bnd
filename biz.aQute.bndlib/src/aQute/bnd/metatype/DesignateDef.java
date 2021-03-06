package aQute.bnd.metatype;

import aQute.bnd.osgi.*;
import aQute.lib.tag.*;

class DesignateDef {
	
	String ocdRef;
	String pid;
	boolean factory;
	
	public DesignateDef(String ocdRef, String pid, boolean factory) {
		this.ocdRef = ocdRef;
		this.pid = pid;
		this.factory = factory;
	}

	public void prepare(Analyzer analyzer) {
		
	}

	Tag getOuterTag() {
		Tag metadata = new Tag("metatype:MetaData").addAttribute("xmlns:metatype", MetatypeVersion.VERSION_1_3.getNamespace());
		
		metadata.addContent(getInnerTag());
		
		return metadata;
		
	}

	Tag getInnerTag() {
		Tag designate = new Tag("Designate");
		if (factory) {
			designate.addAttribute("factoryPid", pid);
		} else {
			designate.addAttribute("pid", pid);
		}
		new Tag(designate, "Object").addAttribute("ocdref", ocdRef);
		return designate;
	}

}
