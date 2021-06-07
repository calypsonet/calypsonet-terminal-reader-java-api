/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://www.calypsonet-asso.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.calypsonet.terminal.reader;

import java.util.concurrent.ExecutorService;
import org.calypsonet.terminal.reader.spi.CardReaderObservationExceptionHandlerSpi;
import org.calypsonet.terminal.reader.spi.CardReaderObserverSpi;

/**
 * Card reader able to observe the insertion/removal of cards.
 *
 * @since 1.0
 */
public interface ObservableCardReader extends CardReader {

  /**
   * The options that apply when a card is detected.
   *
   * @since 1.0
   */
  enum NotificationMode {

    /**
     * All cards presented to the readers are notified to the observers, regardless of the result of
     * the selection.
     *
     * @since 1.0
     */
    ALWAYS,
    /**
     * Only the cards that have been successfully selected will be notified to the observers. The
     * others will be ignored and the application will not be aware of their presence.
     *
     * @since 1.0
     */
    MATCHED_ONLY
  }

  /**
   * Card detection management options to be applied after processing a card.
   *
   * @since 1.0
   */
  enum DetectionMode {

    /**
     * Continue waiting for the insertion of a next card.
     *
     * @since 1.0
     */
    REPEATING,

    /**
     * Stop and wait for a restart signal.
     *
     * @since 1.0
     */
    SINGLESHOT
  }

  /**
   * Configures the reader to use a custom thread pool for events notification.
   *
   * <p>The custom pool should be flexible enough to handle many concurrent tasks as each {@link
   * CardReaderEvent} are executed asynchronously.
   *
   * <p>The use of this method is optional and depends on the needs of the application.<br>
   * When used, the event notification will always be done asynchronously. Otherwise, the
   * notification can be synchronous or asynchronous depending on the type of reader.
   *
   * @param eventNotificationExecutorService The executor service provided by the application.
   * @since 1.0
   */
  void setEventNotificationExecutorService(ExecutorService eventNotificationExecutorService);

  /**
   * Sets the exception handler.
   *
   * <p>The invocation of this method is <b>mandatory</b> when the reader has to be observed.
   *
   * <p>In case of a fatal error during the observation, the handler will receive a notification.
   *
   * @param exceptionHandler The exception handler implemented by the application.
   * @since 1.0
   */
  void setReaderObservationExceptionHandler(
      CardReaderObservationExceptionHandlerSpi exceptionHandler);

  /**
   * Register a new observer to be notified when a reader event occurs.
   *
   * <p>The provided observer must implement the {@link CardReaderObserverSpi} interface to be able
   * to receive the events produced by this reader (card insertion, removal, etc.)
   *
   * @param observer An observer object implementing the required interface (should be not null).
   * @since 1.0
   */
  void addObserver(CardReaderObserverSpi observer);

  /**
   * Unregister a reader observer.
   *
   * <p>The observer will no longer receive any of the events produced by this reader.
   *
   * @param observer The observer object to be removed (should be not null).
   * @since 1.0
   */
  void removeObserver(CardReaderObserverSpi observer);

  /**
   * Unregister all observers at once
   *
   * @since 1.0
   */
  void clearObservers();

  /**
   * Provides the current number of registered observers.
   *
   * @return An int.
   * @since 1.0
   */
  int countObservers();

  /**
   * Starts the card detection. Once activated, the application can be notified of the arrival of a
   * card.
   *
   * <p>The {@link DetectionMode} indicates the action to be followed after processing the card.
   *
   * @param detectionMode The card detection mode.
   * @since 1.0
   */
  void startCardDetection(DetectionMode detectionMode);

  /**
   * Stops the card detection.
   *
   * @since 1.0
   */
  void stopCardDetection();

  /**
   * Terminates the card processing.
   *
   * <p>This method notifies the observation process that the processing of the card has been
   * completed in order to ensure that the card monitoring cycle runs properly.<br>
   * It is <b>mandatory</b> to invoke it when the physical communication channel with the card could
   * not be closed. <br>
   * This method will do nothing if the channel has already been closed.<br>
   * The channel closing is nominally managed during the last transmission with the card. However,
   * there are cases where exchanges with the card are interrupted (e.g. by an exception), in which
   * case it is necessary to explicitly close the channel using this method.
   *
   * @since 1.0
   */
  void finalizeCardProcessing();
}
