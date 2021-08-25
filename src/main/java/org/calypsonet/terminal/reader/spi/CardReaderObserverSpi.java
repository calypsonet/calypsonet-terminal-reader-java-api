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
package org.calypsonet.terminal.reader.spi;

import org.calypsonet.terminal.reader.CardReaderEvent;

/**
 * Reader observer to implement in order to receive {@link CardReaderEvent} from a {@link
 * org.calypsonet.terminal.reader.ObservableCardReader}.
 *
 * @since 1.0.0
 */
public interface CardReaderObserverSpi {

  /**
   * Invoked when a reader event occurs.
   *
   * <p>The event notification should be done <b>sequentially</b> and <b>synchronously</b> but may
   * depend on the implementation used.
   *
   * @param readerEvent The not null {@link CardReaderEvent} containing the event data.
   * @since 1.0.0
   */
  void onReaderEvent(final CardReaderEvent readerEvent);
}
