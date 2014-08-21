/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.tortoiseshell.lib;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.xtext.tortoiseshell.lib.ITortoiseEvent;
import org.xtext.tortoiseshell.lib.Tortoise;

@Data
@SuppressWarnings("all")
public class MoveEvent implements ITortoiseEvent {
  private final Tortoise _tortoise;
  
  private final Point _oldPosition;
  
  public MoveEvent(final Tortoise tortoise, final Point oldPosition) {
    super();
    this._tortoise = tortoise;
    this._oldPosition = oldPosition;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._tortoise== null) ? 0 : this._tortoise.hashCode());
    result = prime * result + ((this._oldPosition== null) ? 0 : this._oldPosition.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MoveEvent other = (MoveEvent) obj;
    if (this._tortoise == null) {
      if (other._tortoise != null)
        return false;
    } else if (!this._tortoise.equals(other._tortoise))
      return false;
    if (this._oldPosition == null) {
      if (other._oldPosition != null)
        return false;
    } else if (!this._oldPosition.equals(other._oldPosition))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
  
  @Pure
  public Tortoise getTortoise() {
    return this._tortoise;
  }
  
  @Pure
  public Point getOldPosition() {
    return this._oldPosition;
  }
}
