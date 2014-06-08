/**
 * Created by jon on 8/06/14.
 */

package com.thing.rpg_droid.pathfinder;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

public class character
{ 
	private String mName = "";
	
	private int mLevel = 1;
	
	private Appearance mAppearance = new Appearance();
	
	private Hashtable<Ability.AbilityName, Ability> mAbilities = new Hashtable<Ability.AbilityName, Ability>();
	
	private ArrayList<Skill> mSkills = new ArrayList<Skill>();
	
	private ArrayList<Spell> mSpells = new ArrayList<Spell>();
	
	public character()
	{
		
	}

    /***
     *
     * @param pStream
     * @return
     */
    static public character Load(InputStream pStream)
    {
        return null;
    }

    /***
     *
     * @param pStream
     */
    public void Save(OutputStream pStream)
    {

    }
	
	public String getName() { return mName; }
	
	public void setName(String pName) { mName = pName; }
	
	public Ability getAbility(Ability.AbilityName pName) { return mAbilities.get(pName); }
	
	public void setAbility(Ability.AbilityName pName, Ability pAbility) { mAbilities.put(pName, pAbility); }
}
