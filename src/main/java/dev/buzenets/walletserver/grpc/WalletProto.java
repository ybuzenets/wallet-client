// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wallet.proto

package dev.buzenets.walletserver.grpc;

public final class WalletProto {
  private WalletProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_wallet_WalletRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_wallet_WalletRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_wallet_BalanceSummary_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_wallet_BalanceSummary_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_wallet_BalanceSummary_AmountEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_wallet_BalanceSummary_AmountEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014wallet.proto\022\006wallet\032\033google/protobuf/" +
      "empty.proto\"Q\n\rWalletRequest\022\014\n\004user\030\001 \001" +
      "(\003\022\016\n\006amount\030\002 \001(\t\022\"\n\010currency\030\003 \001(\0162\020.w" +
      "allet.CURRENCY\"s\n\016BalanceSummary\0222\n\006amou" +
      "nt\030\001 \003(\0132\".wallet.BalanceSummary.AmountE" +
      "ntry\032-\n\013AmountEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005valu" +
      "e\030\002 \001(\t:\0028\001*%\n\010CURRENCY\022\007\n\003USD\020\000\022\007\n\003EUR\020" +
      "\001\022\007\n\003GBP\020\0022\275\001\n\006Wallet\022:\n\007Deposit\022\025.walle" +
      "t.WalletRequest\032\026.google.protobuf.Empty\"" +
      "\000\022;\n\010Withdraw\022\025.wallet.WalletRequest\032\026.g" +
      "oogle.protobuf.Empty\"\000\022:\n\007Balance\022\025.wall" +
      "et.WalletRequest\032\026.wallet.BalanceSummary" +
      "\"\000B/\n\036dev.buzenets.walletserver.grpcB\013Wa" +
      "lletProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        }, assigner);
    internal_static_wallet_WalletRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_wallet_WalletRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_wallet_WalletRequest_descriptor,
        new java.lang.String[] { "User", "Amount", "Currency", });
    internal_static_wallet_BalanceSummary_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_wallet_BalanceSummary_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_wallet_BalanceSummary_descriptor,
        new java.lang.String[] { "Amount", });
    internal_static_wallet_BalanceSummary_AmountEntry_descriptor =
      internal_static_wallet_BalanceSummary_descriptor.getNestedTypes().get(0);
    internal_static_wallet_BalanceSummary_AmountEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_wallet_BalanceSummary_AmountEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
