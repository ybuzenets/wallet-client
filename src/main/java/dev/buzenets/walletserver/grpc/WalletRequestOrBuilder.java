// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wallet.proto

package dev.buzenets.walletserver.grpc;

public interface WalletRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:wallet.WalletRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 user = 1;</code>
   */
  long getUser();

  /**
   * <code>string amount = 2;</code>
   */
  java.lang.String getAmount();
  /**
   * <code>string amount = 2;</code>
   */
  com.google.protobuf.ByteString
      getAmountBytes();

  /**
   * <code>.wallet.CURRENCY currency = 3;</code>
   */
  int getCurrencyValue();
  /**
   * <code>.wallet.CURRENCY currency = 3;</code>
   */
  dev.buzenets.walletserver.grpc.CURRENCY getCurrency();
}
