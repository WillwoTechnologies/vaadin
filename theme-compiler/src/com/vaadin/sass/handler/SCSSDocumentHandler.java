/*
 * Copyright 2011 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.sass.handler;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.css.sac.DocumentHandler;
import org.w3c.css.sac.LexicalUnit;
import org.w3c.css.sac.SACMediaList;
import org.w3c.css.sac.SelectorList;

import com.vaadin.sass.ScssStylesheet;
import com.vaadin.sass.tree.ForNode;
import com.vaadin.sass.tree.MixinDefNode;
import com.vaadin.sass.tree.VariableNode;
import com.vaadin.sass.tree.WhileNode;
import com.vaadin.sass.tree.controldirective.EachDefNode;

public interface SCSSDocumentHandler extends DocumentHandler {
    ScssStylesheet getStyleSheet();

    void variable(String name, LexicalUnit value, boolean guarded);

    void startMixinDirective(String name, Collection<VariableNode> args);

    void endMixinDirective(String name, Collection<VariableNode> args);

    MixinDefNode mixinDirective(String name, String args, String body);

    void debugDirective();

    ForNode forDirective(String var, String from, String to, boolean exclusive,
            String body);

    WhileNode whileDirective(String condition, String body);

    void extendDirective(SelectorList list);

    void startNestedProperties(String name);

    void endNestedProperties(String name);

    void includeDirective(String name, Collection<LexicalUnit> args);

    void importStyle(String uri, SACMediaList media, boolean isURL);

    void property(String name, LexicalUnit value, boolean important,
            String comment);

    EachDefNode startEachDirective(String variable, ArrayList<String> list);

    void endEachDirective();

    void startIfElseDirective();

    void endIfElseDirective();

    void ifDirective(String evaluator);

    void elseDirective();

}