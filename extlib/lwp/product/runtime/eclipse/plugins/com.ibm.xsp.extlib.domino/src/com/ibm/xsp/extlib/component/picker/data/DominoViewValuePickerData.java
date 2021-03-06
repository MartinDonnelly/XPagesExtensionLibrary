/*
 * � Copyright IBM Corp. 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package com.ibm.xsp.extlib.component.picker.data;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;



/**
 * Domino view data provider for a name picker.
 * <p>
 * The view must be have a key and the key is the id of each entry.
 * </p>
 */
public class DominoViewValuePickerData extends DominoViewPickerData implements IValuePickerData {

	public String searchType;
	
	public DominoViewValuePickerData() {
	}
	
    @Override
	public String getSearchType() {
        if (searchType != null) {
            return searchType;
        }
        ValueBinding vb = getValueBinding("searchType"); //$NON-NLS-1$
        if (vb != null) {
            return (String)vb.getValue(getFacesContext());
        }

        return null;
    }
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    @Override
    public void restoreState(FacesContext _context, Object _state) {
        Object _values[] = (Object[]) _state;
        super.restoreState(_context, _values[0]);
        searchType = (String)_values[1];
    }

    @Override
    public Object saveState(FacesContext _context) {
        Object _values[] = new Object[2];
        _values[0] = super.saveState(_context);
        _values[1] = searchType;
        return _values;
    }

}