/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.calypsonet.terminal.reader.selection;

/**
 * Response of the execution of a scheduled selection scenario provided by a {@link
 * org.calypsonet.terminal.reader.CardReaderEvent}.
 *
 * <p>Contains the card's responses to one or more of the scenario's selection cases, i.e. the data
 * from the selection step itself and any responses to commands that may have been executed
 * afterwards.
 *
 * <p>It is necessary to use the method {@link
 * CardSelectionService#parseScheduledCardSelectionsResponse(ScheduledCardSelectionsResponse)} to
 * analyze the result.
 *
 * @since 1.0
 */
public interface ScheduledCardSelectionsResponse {}
